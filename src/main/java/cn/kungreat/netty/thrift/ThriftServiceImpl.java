package cn.kungreat.netty.thrift;

import cn.kungreat.netty.domain.DataException;
import cn.kungreat.netty.domain.User;
import cn.kungreat.netty.domain.UserService;
import org.apache.thrift.TException;

public class ThriftServiceImpl implements UserService.Iface {

    @Override
    public User getUserById(int id) throws DataException, TException {
        System.out.println("getUserById"+"调用了");
        User user = new User();
        user.setId(id);
        user.setAge(32);
        user.setName("kun");
        return user;
    }

    @Override
    public void saveUser(User user) throws DataException, TException {
        System.out.println("saveUser"+"调用了");
        System.out.println(user);
    }
}