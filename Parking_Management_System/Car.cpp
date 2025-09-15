#include "Car.hpp"

using namespace std;

Car::Car(string license) : Vehicle(license) {
    cout<<"Car created with License: "<<license<<endl;
} 
