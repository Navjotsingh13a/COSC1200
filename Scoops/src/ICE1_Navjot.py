# Name: Navjot Singh
# Date: May 16, 2024
# Modified: May 16, 2024
# Description: This python code calculates the average budget of a predefined list of movies, identifies and
# lists the movies with above_average budgets and prints the count of such movies.

# Original list of movies
Movies = [
    ("Eternal Sunshine of the Spotless Mind", 20000000),
    ("Memento", 9000000),
    ("Requiem for a Dream", 4500000),
    ("Pirates of the Caribbean: On Stranger Tides", 379000000),
    ("Avengers: Age of Ultron", 365000000),
    ("Avengers: Endgame", 356000000),
    ("Incredibles 2", 200000000)
]

# Calculate the average budget
total_budget = 0
for movie in Movies :
    total_budget += movie[1]
average_budget = total_budget / len(Movies)

# A function to identify films with budgets above average
high_budget_movies = []
for name, budget in Movies:
    if budget > average_budget:
     high_budget_movies.append((name,budget))

# A function to add additional films
number_of_movies_to_add = int(input("What numbers of films would you like to add? "))
for _ in range(number_of_movies_to_add):
   movie_name = input("Enter the movie name: ")
   movie_budget =int(input("Enter the movie budget: "))
   Movies.append((movie_name, movie_budget))

# Print the results
print(f"\nThe average budget of all movies is : $ {average_budget:.0f}")

high_budget_movies_count = 0
for name, budget in Movies:
   if budget > average_budget:
      high_budget_movies_count += 1
      print(f"{name}: ${budget} (which is ${budget- average_budget:.0f}) above the average")

print(f"\nNumber of movies with a budget higher than the average: {high_budget_movies_count}")