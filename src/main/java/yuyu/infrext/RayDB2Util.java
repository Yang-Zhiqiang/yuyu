package yuyu.infrext;

import jp.co.slcs.swak.core.util.ExceptionUtil;

import org.hibernate.exception.GenericJDBCException;

public class RayDB2Util {

    public static boolean isDeadRockException(Throwable t){
        if(ExceptionUtil.contains(t, GenericJDBCException.class)){
            for(Throwable eChild : ExceptionUtil.getCauses(t)){
                if("com.ibm.db2.jcc.am.SqlException".equals(eChild.getClass().getName())){
                    if(eChild.getMessage().contains("SQLCODE=-913")){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
