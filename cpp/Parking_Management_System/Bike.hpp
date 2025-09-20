#ifndef BIKE_H
#define BIKE_H

#include <iostream>
#include <string>
#include "Vehicle.hpp"
using namespace std;

class Bike : public Vehicle{
    public:
    Bike(string license);
};
#endif