#ifndef VEHICLE_H
#define VEHICLE_H

#include <iostream>
#include <string>
using namespace std;
class Vehicle{
    string license;

    public:
    Vehicle (string license);
    string getLicense();
};
#endif