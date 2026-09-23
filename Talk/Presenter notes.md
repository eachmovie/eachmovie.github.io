# SLIDE 1

Hi, I’m John DeTreville. This is a historical talk about some work I did thirty years ago on a system called EachMovie. This is the “Past, Present, and Future” track and I picked “PAST.” BTW, NEVER call anything THE first, ESPECIALLY your own work! ［⏹］


# SLIDE 2

I don’t have ANY tee-snee charts. It’s not that kind of talk. (Maybe you’re in the wrong room?)

But the paper does have a FEW numbers in it. READ THE PAPER if you want some numbers. ［⏹］


# SLIDE 3

Now, the Nineties were a MAGICAL TIME ［mime 🌈 two-handed］, even if most of the folks HERE were hardly even BORN yet! ［⏹］

Computers were slow. “The Wide, Wide World of the Web” was just “The Web.” There were VERY FEW recommender systems, and there were NO LATENT recommender systems. So I figured, LET’S INVENT LATENT RECOMMENDER SYSTEMS!

And so we did. We did it for movies. ［⏹］


# SLIDE 4

With no other recommender systems to copy, I had to copy HUMAN recommender systems—like ROGER EBERT, very famous movie critic. So, how many ★s does a movie GET in his reviews? He said it should be RELATIVE, not absolute.

If he gave 3★ to, say, “Hellboy”—a comic-book movie—people would say, why did you give THAT 3★? HUUUH? But HE said, you want INDIVIDUALIZED RECOMMENDATIONS. And if SUPERMAN'S 4, then HELLBOY’s 3, and THE PUNISHER is 2. (This is pretty darn close to a latent-space approach!) ［⏹］


# SLIDE 5

There’s not much still SURVIVING from EachMovie, since it got SHUT DOWN in 1997 while the company was laser-focused on GOING OUT OF BUSINESS.

There’s only a FEW artifacts extant, including an impressive-looking US PATENT of mine, patenting ［looks at patent］ LATENT… RECOMMENDER… SYSTEMS… huh!—Applied 1996, Granted 2000, Expired 2016, so please feel free to use it now! (It overlapped the Netflix Prize, so half that money is rightfully mine!) ［⏹］

EachMovie had about 2.8 million votes, and the vote matrix was **98% sparse**. The votes ran from 0★ to 5★, plus a special vote: “Sounds Awful,” which means, OMG, that “Sounds Awful!!!” ［⏹］


# SLIDE 6

What’s “98% sparse” LOOK like? This pie chart SHOWS all those votes, but NOT SO MUCH, since most of the elements in the vote matrix were MISSING. Like THIS. ［⏹ pie chart recedes to 2.37% in the upper left, leaving a giant grey-scale question mark］

This FINAL FIGURE is of course to scale. A LITTLE bit is in color (a little over 2%) but **98%** of it is gray-scale. What to do, what to do? ［⏹］


# SLIDE 7

Here’s some math that shows what you can do. ● It’s in the paper. ● Read the paper. ［⏹］


# SLIDE 8

Let's look at MY 465 votes in EachMovie. Why MY votes? Because I had PERMISSION to use MY votes in these slides.

We bin them up by value: over there is “Sounds Awful,” then 0★, 1★, 2★, up to 5★. We use my votes to draw the GIRAFFE CHART so that we can... oh, EFF IT, WRONG GIRAFFE CHART!!! ［panic: original giraffe chart shows seven photorealistic giraffes with labels］ ［⏹ to reveal hidden chart］

Okay, OKAY, here's the RIGHT Giraffe Chart!!! (WHEW!) Look at the giraffe curve in the MIDDLE for 3★. I had about a HUNDRED votes I gave 3★. (This is all on GitHub: eachmovie.github.io.) We draw a nice little giraffe curve, and divide IT by QUARTILES. The MIDDLE is pretty flat but the OUTLIERS are “INTERESTING.” EachMovie says I SHOULD have ranked “Toy Story” HIGHER. Maybe it's right! ［⏹］


# SLIDE 9

There was ONE REALLY IMPORTANT THING about EachMovie:  we got USER REACTIONS back from the users. It’s very hard NOWADAYS to find users of AUTOMATED RECOMMENDER SYSTEMS who’ve never SEEN an AUTOMATED RECOMMENDER SYSTEM before IN ● THEIR ● ENTIRE ● LIVES. But, you know, **I** found them! HA! Here's what some said. One person said: ［⏹］

YOU'RE NOT GOD, BUT MUCH OF THE TIME YOU'RE CLOSE. HA! Looks GREAT on my résumé! ［⏹］


# SLIDE 10

［⏹］

When Roger Ebert reviewed EachMovie, he said, WOW, it actually works! It's UNCANNILY ● ACCURATE! Are they CHEATING? I'll launch a SYBIL ATTACK—yeah, STUPID COMPUTERS!— and “THEY” won't be able to figure that out… right?

Well, EachMovie STILL worked! He compared EachMovie to _THE WIZARD OF OZ_, which ALSO looks great on my résumé, AND it means EachMovie PASSED THE TURING TEST! ［⏹ to expose bumper sticker］

So OF COURSE I made up BUMPER STICKERS—took his “UNCANNILY ACCURATE” & added an EXCLAMATION POINT to make it look even BETTER!!! I have some of these up here right now ［WAVE bumper stickers］ that you can come up and ASK for, if you have some MONEY. ［⏹］


# SLIDE 11

Let’s get ready for the fabulous EachMovie MUSIC VIDEO! Here’s the TOP TEN movies in EachMovie, based on how many K★ they got total. We got _Aladdin_, _The Shawshank Redemption_, all the way up to _Apollo 13_. These are all VERY different movies, so let’s PLOT them—not the EASY way but the HARD way! BTW, these icons are VERY CRUDELY DRAWN.

BTW, look at the FOOTNOTE! You should ALL go see THIS year's FEEL-GOOD COMEDY HIT OF THE SUMMER™, Coyote vs. ACM (2026). ［⏹］


# SLIDE 12

Here, we take Principal Components 1, 2, and 3. We PROJECT all those icons onto a rotating 3-D subspace. (It’s a PERSPECTIVE plot.) When you do the math RIGHT, here's what you get. ［⏹］

OOH, AAH. And I have a BUNCH of this video; we should watch it all together later on. It's FASCINATING. ［ ❤］**I** LOVE it! ［⏹］


# SLIDE 13

EachMovie lasted through 1997, and then got SHUT DOWN while DEC went out of business, funny story.

The EachMovie dataset was available until 2004, another funny story.

Look at the slides online to see some cool details! But NOW, EachMovie’s GONE. ［⏹ to erase screenshot］

Bye bye. ［⏹］


# SLIDE 14

But I have the SOURCE CODE, and the ORIGINAL DATASET (because someone FOUND them in their garage, and MAILED them to me. *THANKS*!) So I RECONSTRUCTED it, and HERE'S what you get! ［⏹ to show new screenshot］

Those latent factors computed back in the 1990s STILL WORK. **MATH DOESN'T DIE.** That's the NEAT THING. And the code even prints out COPYRIGHT 1996, DIGITAL EQUIPMENT CORPORATION. ［⏹］


# SLIDE 15

Here's a closing EPIGRAPH, also EPILOG, so you get two for one! T.S. ELIOT, Very Famous Twentieth Century Modernist Poet, wrote: ［reads］ “I HAVE HEARD THE MERMAIDS SINGING, EACH TO EACH”—that’s where the name COMES from, EachMovie. ［repeats］ _“Mermaids singing each to each,”_ ［reads］ “I ● DO ● NOT ● THINK ● THAT ● THEY ● WILL ● SING ● TO ● ME.” ［😊］ Well, that seems SAD, doesn't it? ［⏹］

And so I THOUGHT, let’s **DO** something about that! And THAT'S THE STORY OF EACHMOVIE, thankyouverymuch. ［⏹］


# SLIDE 16

EDITORIAL. (The views expressed here are not those of Digital Equipment Corporation.) ［much more deliberately］ EachMovie was the FIRST ● LATENT ● RECOMMENDER ● SYSTEM. It gave its human USERS human AGENCY. They WANTED to use EachMovie, and to refine its MODELS of their tastes. EachMovie LET *THEM* DRIVE.

As I said, we let users WRITE IN, and many DID. One user wrote that SHE ran EXPERIMENTS with HER EachMovie account, TWIDDLING the KNOBS. She'd change one or two of her votes then click **Submit** and SEE WHAT HAPPENED. (EachMovie updated predictions instantly.) Then she'd change them BACK, watch her predictions snap back into place, THEN try something NEW. This is a TEXTBOOK EXAMPLE of HUMAN AGENCY. We didn't plan for this—it's an EMERGENT PROPERTY—but this KIND of HUMAN AGENCY would SEEM like something you'd want to TRY to REPLICATE in modern systems.

But THAT ● was ● THEN ● and ● THIS ● is ● NOW. **NOW** we're on a DIFFERENT timeline. We're STUCK in BACK TO THE FUTURE PART II (1989) and BIFF TANNEN is RUNNING THE CASINO! *HE'S* **DIALING** the **DOOMSCROLLAMINE** all the way **UP TO 11!** (BIFF is the BAD GUY in the movie!)

So, what to do, what to do? ［move hands to mime a balance］ THESE are the TWO PATHS WE CAN GO BY. And, IN THE LON— NO, **NO**, no, RIGHT **NOW!**—IT’S ● NOT ● TOO ● LATE ● TO ● CHANGE ● THE ● ROAD ● WE’RE ● ON.

Makes you wonder. Yeah. Yeah. Really, really makes you wonder. ［⏹］


# SLIDE 17

［Stand Up Straight and face audience, visible arm akimbo, fist visible on waist］［😊 😊 😊］

So NOW it’s time for QUESTIONS! ANYONE? I’m playing this fabulous SILENT MUSIC VIDEO to help EVERYONE think of EASY QUESTIONS with EASY ANSWERS!!!

［⏹］ ［move downstage center as video starts. as music plays, strip off gray embroidered overshirt to expose bright orange T-shirt emblazoned with GOT QUESTIONS?, then return to lectern just as brief music fades while video plays on］

［😊］ Here are some TOPICS for CONVERSATION! Anyone?

［take questions］

［"be sure to LIKE and SUBSCRIBE !!!"］

［exit _as if_ "pursued by a bear" (Winter's Tale, Act 3, Scene 3); the bear will not be taking questions］
