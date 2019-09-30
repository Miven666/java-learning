package miven.java.collection.list;

import java.io.Serializable;

/**
 * 红苹果
 *
 * @author mingzhi.xie
 * @date 2019/4/22.
 */
class RedApple extends Apple implements Call, Serializable {

    private static final long serialVersionUID = -443970050733866935L;

    RedApple() {
        name = "I'm name is RedApple";
    }

    RedApple(int id) {
        super(id);
        name = "I'm name is RedApple";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new RedApple();
    }
}
