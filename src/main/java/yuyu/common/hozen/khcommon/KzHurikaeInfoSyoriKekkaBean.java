package yuyu.common.hozen.khcommon;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * 契約保全 契約保全共通 口座振替情報取得処理結果Beanクラス
 */
public class KzHurikaeInfoSyoriKekkaBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private String kzhurikaeymdZen;

    @Getter @Setter
    private String kzhurikaeiraikngkZen;

    @Getter @Setter
    private String jyuutouymZen;

    @Getter @Setter
    private String jyutoukaisuumZen;
}
