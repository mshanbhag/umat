% Author: Madhusoodan Shanbhag
% Date: 7/24/2011

% This code shows a prolog knowledge base that describes the locations of certain
% Indian cities. It defines a single relation, called located_in which
% relates a city to a larger geographical unit.

located_in(noida, up).      %NOIDA is located in Uttar Pradesh
located_in(bangalore, karnataka).
located_in(mangalore, karnataka).
located_in(mumbai, maharashtra).
located_in(pune, maharashtra).
located_in(trivendram, kerala).
located_in(patna, bihar).
located_in(City, india) :- located_in(City, karnataka).  % A city is located in India if it is in karnataka.
located_in(City, india) :- located_in(City, maharashtra).
located_in(City, asia)  :- located_in(City, india).
% Name of the predicate always begins with lowercase letters.
% Names begin with capital letters are variables and can be given any value.
% This program contains only one variable called City.

% It can be said that predicate located_in is NONDETERMINISTIC because it can have multiple
% answers.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Exercise 1.4.1
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Load geo.pl in your prolog system and try it out. How does your prolog system
% responds to each of the following queries?
% located_in(mumbai, maharashtra).
% located_in(bangalore, maharashtra).
% located_in(What, karnataka).
% located_in(patna, What).
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%  Exercise 1.4.2
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Add your home town and state and country to geo.pl and demonstrate that
% the modified version works correctly.
%
