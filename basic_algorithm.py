def rectangle_area(rec_width, rec_length):
    return rec_width * rec_length

def play_a_bad_guessing_game():
    guess = input("What is that cat over there thinking about? ")
    print("I don't think that " + guess + " is what that cat is thinking about")

play_a_bad_guessing_game()