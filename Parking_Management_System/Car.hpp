#ifndef CAR_H
#define CAR_H


#include <iostream>
#include "Vehicle.hpp"
using namespace std;
class Car : public Vehicle{
    public:
    Car(string license);
};
#endif