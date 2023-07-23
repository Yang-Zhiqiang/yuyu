package yuyu.infr.db.dialect;

import org.hibernate.dialect.DB2390Dialect;

public class ExDB2390Dialect extends DB2390Dialect {
    @Override
    public String getForUpdateString() {
        return " for update with rs use and keep update locks";
    }
}
