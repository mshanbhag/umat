% Author: Madhusoodan Shanbhag
% Date: 7/24/2011
% Prolog Programming in Depth
% Chapter 1
% How Prolog Works
in_united_states(X) :- in_georgia(X). %Rule
in_georgia(atlanta).                  %Fact
% in_united_states is a PREDICATE
% in_georgia is a PREDICATE
% A predicate can take any fixed number of argument(parameters).
female(sharon).
% Above statement means, sheron is a female.
mother(melody, sharon).
% Above statement would mean "Melody is mother of sharon."
%------------------------------------------------------------------------
% A predicate that takes N arguments is called as N-Place Predicate.
% In above example, in_united_states , in_georgia , female are one
% place predicates. While mother is TWO place argument.
% Number of arguments a predicate takes is called as its ARITY.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%%       Exercise 1.2.1
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%    Give an example, in Prolog, of a fact, a rule, a clause, a one place
%    predicate, and a predicate of arity 2.
%-----------------------------------------------------------------------
%Fact
prime_minister(ab_vajpei).
%-----------------------------------------------------------------------
% Rule
president(India) :- commonder_in_charge(India).
%-----------------------------------------------------------------------
% Clause
located_in(noida, up).
%-----------------------------------------------------------------------
% One Place Predicate.
technical_analyst(madhusoodan).
%-----------------------------------------------------------------------
% Predicate of arity 2.
brother(madhusoodan, madhura).
%-----------------------------------------------------------------------
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                     Exercise 1.2.2
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% In the previous example, we representated 'in georgia" as a property of
% Atlanta. Write a prolog fact the represents 'In' as a relation between
% Atlanta and georgia.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% SOLUTION
in(georgia, atlanta).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                      Exercise 1.2.3
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% How would you represent, in prolog the fact"Atlanta is at latitude 34
% north and Longitude 84 west?
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
atlanta(34, n, 84, w).

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%                  Exercise 1.3.1
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% If you have not done so already, familiarize yourself with the manuals
% for the version of prolog that you will be using.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Start reading after finishing basic part of this book.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% In the prolog that you are using,
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Name of the predicate always begins with lowercase letters.
% Names begin with capital letters are variables and can be given any value.












