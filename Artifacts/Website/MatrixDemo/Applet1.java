import java.awt.*;
import java.applet.*;
import java.util.*;

public class Applet1 extends Applet implements Runnable {
	Scrollbar[][] scrollbar;
	Checkbox[][] checkbox;
	double[][] p, xi;
    double fp = 0;

    final int M = 5;
    final int N = 7;
    final int K = 2;
    final double damp = 1;

    Random random = new Random();

    double fabs(double x) {
        return x >= 0 ? x : -x;
    };

    int sgn(double x) {
        return x > 0 ? 1 : x < 0 ? -1 : 0;
    };

    double func() {
        double error = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (checkbox[i][j].getState()) {
                    double pred = 0;
                    for (int k = 0; k < K; k++)
                        pred += p[i][k] * p[M + j][k];
                    double err = pred - scrollbar[i][j].getValue();
                    error += err * err;
                }
            }
        }
        for (int ij = 0; ij < M + N; ij++)
            for (int k = 0; k < K; k++)
                error += damp * p[ij][k] * p[ij][k];
        return error;
    };

    void dfunc() {
        for (int ij = 0; ij < M + N; ij++) {
            for (int k = 0; k < K; k++) {
                xi[ij][k] = 0;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (checkbox[i][j].getState()) {
                    double pred = 0;
                    for (int k = 0; k < K; k++) {
                        pred += p[i][k] * p[M + j][k];
                    }
                    double err = pred - scrollbar[i][j].getValue();
                    for (int k = 0; k < K; k++) {
                        double xik = p[i][k];
                        double yjk = p[M + j][k];
                        xi[i][k] += 2 * yjk * err;
                        xi[M + j][k] += 2 * xik * err;
                    }
                }
            }
        }
        for (int ij = 0; ij < M + N; ij++) {
            for (int k = 0; k < K; k++) {
                xi[ij][k] += 2 * damp * p[ij][k];
            }
        }
    };

    double linmin() {
        double b4 = 0, b3 = 0, b2 = 0, b1 = 0, b0 = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (checkbox[i][j].getState()) {
                    double a2 = 0, a1 = 0, a0 = 0;
                    for (int k = 0; k < K; k++) {
                        double xi0 = p[i][k];
                        double yj0 = p[M + j][k];
                        double dxi = xi[i][k];
                        double dyj = xi[M + j][k];
                        a2 += dxi * dyj;
                        a1 += dxi * yj0 + dyj * xi0;
                        a0 += xi0 * yj0;
                    }
                    a0 -= scrollbar[i][j].getValue();
                    b4 += a2 * a2;
                    b3 += 2 * a1 * a2;
                    b2 += 2 * a0 * a2 + a1 * a1;
                    b1 += 2 * a0 * a1;
                    b0 += a0 * a0;
                }
            }
        }
        for (int ij = 0; ij < M + N; ij++) {
            for (int k = 0; k < K; k++) {
                double xi0 = p[ij][k];
                double dxi = xi[ij][k];
                b2 += damp * dxi * dxi;
                b1 += damp * 2 * dxi * xi0;
                b0 += damp * xi0 * xi0;
            }
        }
        double val = 0;
        double root = 0;
        double a0 = 4 * b4;
        double a1 = 3 * b3 / a0;
        double a2 = 2 * b2 / a0;
        double a3 = b1 / a0;
        double Q = (a1 * a1 - 3 * a2) / 9;
        double R = (2 * a1 * a1 * a1 - 9 * a1 * a2 + 27 * a3) / 54;
        double disc = R * R - Q * Q * Q;
        if (disc >= 0) {
            double temp1 = Math.pow(Math.sqrt(disc) + fabs(R), 1.0 / 3);
            root = -sgn(R) * (temp1 + Q / temp1) - a1 / 3;
            val = ((((b4 * root + b3) * root + b2) * root) + b1) * root + b0;
        } else {
            double theta = Math.acos(R / Math.sqrt(Q * Q * Q));
            double sq = Math.sqrt(Q);
            double root1 = -2 * sq * Math.cos(theta / 3) - a1 / 3;
            double root2 = -2 * sq * Math.cos((theta + 2 * Math.PI) / 3) - a1 / 3;
            double root3 = -2 * sq * Math.cos((theta + 4 * Math.PI) / 3) - a1 / 3;
            double val1 = ((((b4 * root1 + b3) * root1 + b2) * root1) + b1) * root1 + b0;
            double val2 = ((((b4 * root2 + b3) * root2 + b2) * root2) + b1) * root2 + b0;
            double val3 = ((((b4 * root3 + b3) * root3 + b2) * root3) + b1) * root3 + b0;
            if (val1 <= val2 && val1 <= val3) {
                root = root1;
                val = val1;
            } else if (val2 <= val1 && val2 <= val3) {
                root = root2;
                val = val2;
            } else {
                root = root3;
                val = val3;
            }
        }
        if (Double.isNaN(root) || Double.isInfinite(root)) root = 0;
        for (int ij = 0; ij < M + N; ij++) {
            for (int k = 0; k < K; k++) {
                p[ij][k] += (xi[ij][k] *= root);
            }
        }
        return val;
    };

    void reset_all() {
        if (checkbox == null) return;
        for (int ij = 0; ij < M + N; ij++) {
            for (int k = 0; k < K; k++) {
                p[ij][k] += random.nextDouble() / 1000.0;
            }
        }
        dfunc();
        fp = linmin();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!checkbox[i][j].getState()) {
                    double pred = 0;
                    for (int k = 0; k < K; k++) {
                        pred += p[i][k] * p[M + j][k];
                    }
                    int p = pred < 0 ? 0 : pred > 100 ? 100 : (int)pred;
                    scrollbar[i][j].setValue(p);
                }
            }
        }
    }

	void set_bar(int i, int j) {
        checkbox[i][j].setState(true);
        int p = scrollbar[i][j].getValue();
	}

	public void init() {
		super.init();

		setLayout(null);
		addNotify();
		resize(770,280);
		scrollbar = new Scrollbar[M][N];
		checkbox = new Checkbox[M][N];
		for (int i = 0; i < M; i++) {
		    for (int j = 0; j < N; j++) {
		        scrollbar[i][j] = new Scrollbar(Scrollbar.HORIZONTAL, 0, 0, 0, 100);
		        scrollbar[i][j].reshape(35 + 150 * i, 15 + 38 * j, 105, 23);
		        add(scrollbar[i][j]);
		        checkbox[i][j] = new Checkbox("checkbox");
		        checkbox[i][j].reshape(18 + 150 * i, 15 + 38 * j, 14, 20);
		        add(checkbox[i][j]);
		    }
		}
		p = new double[M + N][K];
		xi = new double[M + N][K];
		Thread t = new Thread(this);
		t.setDaemon(true);
		t.start();
	}

	public void run() {
	    for (;;) {
    	    reset_all();
    	    try {
    	        Thread.sleep(100);
    	    } catch (InterruptedException e) {
    	    }
    	}
	}

	public boolean handleEvent(Event event) {
	    switch (event.id) {
        case Event.SCROLL_ABSOLUTE:
        case Event.SCROLL_LINE_DOWN:
        case Event.SCROLL_LINE_UP:
        case Event.SCROLL_PAGE_DOWN:
        case Event.SCROLL_PAGE_UP:
    	    for (int i = 0; i < M; i++) {
    	        for (int j = 0; j < N; j++) {
    	            if (event.target == scrollbar[i][j]) {
    	                set_bar(i, j);
    	            }
    	        }
    	    }
	    }
	    reset_all();
		return super.handleEvent(event);
	}
}
