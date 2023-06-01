import math


class Region:

    def __init__(self, left_top_corner_point, left_down_corner_point, right_top_corner_point, right_down_corner_point, row, column):
        self.row = row
        self.column = column
        self.left_top_corner_point = left_top_corner_point
        self.left_down_corner_point = left_down_corner_point
        self.right_top_corner_point = right_top_corner_point
        self.right_down_corner_point = right_down_corner_point
        self.number_of_cities = 0
        self.isVisitedTemp = False
        self.isVisited = False
        self.cities = []

    def add_suitable_city(self, city):
        first_check = city.x1 > self.left_down_corner_point[0] and city.y1 > self.left_down_corner_point[1]
        second_check = city.x1 > self.left_top_corner_point[0] and city.y1 < self.left_top_corner_point[1]
        third_check = city.x1 < self.right_down_corner_point[0] and city.y1 > self.right_down_corner_point[1]
        fourth_check = city.x1 < self.right_top_corner_point[0] and city.y1 < self.right_top_corner_point[1]
        total_check1 = first_check and second_check and third_check and fourth_check
        first_check = city.x1 == self.left_down_corner_point[0] or city.y1 == self.left_down_corner_point[1]
        second_check = city.x1 == self.right_top_corner_point[0] or city.y1 == self.right_top_corner_point[1]
        total_check2 = first_check or second_check
        if total_check1 or total_check2:
            self.cities.append(city)
            self.number_of_cities += 1
            return True
        return False


class City:

    def __init__(self, city_id, x1, y1):
        self.city_id = city_id
        self.x1 = x1
        self.y1 = y1
        self.point = (x1, y1)
        self.cityID_distance = {} # matris

    def calculate_distance(self, cities):
        for city in cities:
            if city is self: # put is not
                continue
            self.cityID_distance[city.city_id] = round(math.sqrt(((self.x1 - city.x1)**2) + ((self.y1 - city.y1)**2)))


class System:

    def __init__(self, input_file_name, percentage):
        self.input_file_name = input_file_name
        self.regions = {} # keeps Region objects as matrix
        self.row_column_percentage_for_region = percentage # it will be dynamic not static, write a formula for this. !!!!!!!!! mean median for coordiantes, ets.
        self.distanceX = 0 # distance2neighbour_region_for_x_axis
        self.distanceY = 0 # distance2neighbour_region_for_Y_axis

    def read_file(self, input_file):
        x_coordinates = []
        y_coordinates = []
        parsed_lines = []
        number_of_cities = 0
        with open(input_file, 'r') as file:
            lines = file.readlines()
            number_of_cities = len(lines)
            for line in lines:
                parsed_line = line.strip().split(" ")
                while ("" in parsed_line):
                    parsed_line.remove("")
                x_coordinates.append(int(parsed_line[1]))
                y_coordinates.append(int(parsed_line[2]))
                parsed_lines.append(parsed_line)
        return x_coordinates, y_coordinates, parsed_lines, number_of_cities

    def create_regions(self):
        n = int(100 / self.row_column_percentage_for_region)
        for i in range(n):
            row = []
            for j in range(n):
                left_top_point = (j * self.distanceX, (i+1) * self.distanceY)
                left_down_point = (j * self.distanceX, i * self.distanceY)
                right_top_point = ((j+1) * self.distanceX, (i+1) * self.distanceY)
                right_down_point = ((j+1) * self.distanceX, i * self.distanceY)
                row.append(Region(left_top_point, left_down_point, right_top_point, right_down_point, i, j))
            self.regions[i] = row

    def create_cities(self, parsed_lines):
        cities = []
        for parsed_line in parsed_lines:
            cities.append(City(parsed_line[0], int(parsed_line[1]), int(parsed_line[2])))
        return cities

    def place_cities_to_regions(self, parsed_lines, regions):
        cities = self.create_cities(parsed_lines)
        for row in regions.values():
            for region in row:
                added_cities = []
                for city in cities:
                    is_added = region.add_suitable_city(city)
                    if is_added:
                        added_cities.append(city)
                for city in added_cities:
                    cities.remove(city)

    def find_regions_for_max_city(self): # can be improved loops!!!
        n = int(100 / self.row_column_percentage_for_region)
        max = 0
        regions = []
        for i in self.regions:
            for j in range(n):
                number_of_cities = self.regions[i][j].number_of_cities
                if number_of_cities > max and not self.regions[i][j].isVisitedTemp:
                    max = number_of_cities

        for i in self.regions:
            for j in range(n):
                region = self.regions[i][j]
                if region.number_of_cities == max and not region.isVisitedTemp:
                    regions.append(region)
        return regions

    def select_regions_of_half_cities(self, number_of_cities): # can be improved for same transition region by using row column
        order_tour_for_regions = []
        half_city = int(number_of_cities / 2)
        number_of_visited_city = 0
        while True:
            regions = self.find_regions_for_max_city()
            for region in regions:
                number_of_visited_city += region.number_of_cities
                region.isVisitedTemp = True
                order_tour_for_regions.append(region)
                if number_of_visited_city >= half_city:
                    del self.regions
                    return order_tour_for_regions

    def visit_cities(self, ordered_tour_for_regions): # not completed
        for region in ordered_tour_for_regions:
           for city in region.cities:
                city.calculate_distance(region.cities)
        return ordered_tour_for_regions

    def main(self):
        x_coordinates, y_coordinates, parsed_lines, number_of_cities = self.read_file(self.input_file_name)
        upperX = max(x_coordinates) + 500
        lowerX = min(x_coordinates) - 500
        upperY = max(y_coordinates) + 500
        lowerY = min(y_coordinates) - 500
        self.distanceX = ((upperX - lowerX) * self.row_column_percentage_for_region) / 100
        self.distanceY = ((upperY - lowerY) * self.row_column_percentage_for_region) / 100
        self.create_regions()
        #for i in self.regions:
        #    print(self.regions[i][2].row, self.regions[i][2].column)
        self.place_cities_to_regions(parsed_lines, self.regions)
        ordered_tour_for_regions = self.select_regions_of_half_cities(number_of_cities)

        order = 1
        total = 0
        for region in ordered_tour_for_regions:
            print(str(order) + ": Region[" + str(region.row) + "][" + str(region.column) + "]", len(region.cities))
            order += 1
            total += len(region.cities)
        print("\nTotal cities:", total)


        #x = self.visit_cities(ordered_tour_for_regions)
        #for i in x:
        #    for city in i.cities:
        #        print("Region[" + str(i.row) + "]" + "[" + str(i.column) + "]" + str(city.city_id) + str(": "), city.cityID_distance)
        x = 0
        #for i in self.regions:
        #    for counter in range(int(100 / self.row_column_percentage_for_region)):
        #        x = x + len(self.regions[i][counter].cities)
        #print(x, number_of_cities)

        #x = 1
        #for i in self.regions:
        #    for counter in range(int(100 / self.row_column_percentage_for_region)):
        #        print("Region" + str(x) + ": ", self.regions[i][counter].number_of_cities)
        #        x += 1



print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput1 - Regions to visit in order")
input1 = System("example-input-1.txt", 20) # 5
input1.main()
print("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput2 - Regions to visit in order")
input2 = System("example-input-2.txt", 2) # 2
input2.main()
print("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&\nInput3 - Regions to visit in order")
input3 = System("example-input-3.txt", 20) # 5
input3.main()
print("\n&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&")