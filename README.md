# late-riddle






![Screenshot (15)](https://user-images.githubusercontent.com/89356200/193441982-d8b58e28-b655-431a-a4f9-19fda22061d9.png)




![Screenshot (16)](https://user-images.githubusercontent.com/89356200/193441984-910f6e69-b3be-4d23-bfef-10df4e3c0fa5.png)







mysql> select * from admin; select*from courses; select*from student;select*from courses_student;

1. ADMIN TABLE
+----------+----------+
| username | password |
+----------+----------+
| Paras    | abcde    |
+----------+----------+
1 row in set (0.06 sec)


2. COURSES TABLE

+----------+------------+-----------+-------------+---------+
| courseId | courseName | courseFee | No_of_Seats | Batch   |
+----------+------------+-----------+-------------+---------+
|        1 | Android    |     40000 |         790 | Premium |
|        2 | Java       |     50000 |        1676 | Gold    |
|        3 | PHP        |      8000 |         500 | Diamond |
|        4 | Oracle     |     70000 |         550 | Silver  |
|        5 | Python     |    200000 |        1000 | Gold    |
|        8 | JS         |       100 |         900 | premium |
+----------+------------+-----------+-------------+---------+
6 rows in set (0.01 sec)



3. STUDENT TABLE

+----+--------+------------------+----------+
| Id | Name   | Email            | Password |
+----+--------+------------------+----------+
|  1 | John   | John@gmail.com   | abcde    |
|  2 | Carl   | Carl@gmail.com   | awere12  |
|  3 | Messi  | messi@gmail.com  | ronaldo  |
|  4 | Aman   | aman@yahoo.com   | iopjkl   |
|  5 | Rahul  | rahul@gmail.com  | 12345    |
|  6 | Super  | don              | 4        |
|  7 | Super  | super@gmail.com  | iopiop   |
|  8 | mayurs | mayurs@gmail.com | qwerty   |
+----+--------+------------------+----------+
8 rows in set (0.00 sec)


4. COURSES_STUDENT

+----------+------+
| courseId | Id   |
+----------+------+
|        3 |    2 |
|        4 |    3 |
|        4 |    3 |
|        4 |    3 |
|        4 |    3 |
+----------+------+
5 rows in set (0.01 sec)
