-- Doubleing function
doubleMe x = x + x
--Double Double function
--doubleUs x y = x*2 + y*2
doubleUs x y = doubleMe x + doubleMe y

-- Define a function that multiplies a number by 2 but only if that number is 
-- smaller than or equal to 100.

doubleSmallNumber x = 	if x > 100
						then x
						else x*2

doubleSmallNumber1 x = 	( 	if x > 100
							then x
							else x*2	)
							+1
							
