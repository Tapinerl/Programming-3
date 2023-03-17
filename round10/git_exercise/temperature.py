
def main():

    input_ask = string(input("Select transform direction (CF) or (FC): "))

    if input_ask == "CF":
        try:
            input_temp = float(input("Input temperature: "))
        except:
            print("Not valid input")
            exit()

    print("{} C = {} F".format(input_temp, t_transform(input_temp, 'c')))
        
    elif input_ask == "FC":
        try:
            input_temp = float(input("Input temperature: "))
        except:
            print("Not valid input")
            exit()

    print("{} F = {} C".format(input_temp, t_transform(input_temp, 'f')))

    else:
        print("Not valid input")
        exit()

def t_transform(temp, type):

    if type == 'c':
        return float(temp * 9/5 + 32)
    elif type == 'f':
        return float((temp - 32) * 5/9)

    return None

if __name__ == "__main__":
    main()
