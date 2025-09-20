#include "Bike.hpp"

using namespace std;

Bike::Bike(string license) : Vehicle(license) {
    cout<<"Bike created with License: "<<license<<endl;
} 