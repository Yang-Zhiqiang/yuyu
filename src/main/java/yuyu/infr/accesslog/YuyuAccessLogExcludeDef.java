package yuyu.infr.accesslog;

import lombok.Getter;
import lombok.Setter;


/**
 * アクセスログ出力除外定義クラス<br />
 */
public class YuyuAccessLogExcludeDef {

    @Getter @Setter
    private String subsystemId;

    @Getter @Setter
    private String categoryId;

    @Getter @Setter
    private String kinouId;

    @Getter @Setter
    private String propName;

}
