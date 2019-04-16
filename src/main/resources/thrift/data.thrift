namespace java cn.kungreat.netty.domain
typedef i32 int
typedef i64 long

struct User{
    1:optional string name,
    2:optional int age,
    3:required int id
}

exception DataException{
       1:required string messgae,
       2:required bool success,
       3:required string date
}

service UserService{
    User getUserById(1:required int id) throws  (1: DataException dataException),
    void saveUser (1:required User user) throws (1: DataException dataException)
}