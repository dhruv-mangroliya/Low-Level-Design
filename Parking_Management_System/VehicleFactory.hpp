#ifndef VEHICLEFACTORY_H
#define VEHICLEFACTORY_H

#include <iostream>
#include <string>
#include "Vehicle.hpp"
using namespace std;
class VehicleFactory{
    public:
    Vehicle* createVehicle(string type, string license);
};

#endif