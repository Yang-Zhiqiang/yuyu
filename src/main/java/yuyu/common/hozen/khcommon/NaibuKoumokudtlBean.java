package yuyu.common.hozen.khcommon;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import yuyu.def.db.entity.IT_KhShrRireki;
/**
 * 契約保全 契約保全共通 内部共通明細Beanクラス
 */
public class NaibuKoumokudtlBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private IT_KhShrRireki khShrRireki;

    @Getter @Setter
    private KngkMeisaiBean kngkMeisaiBean;

    @Getter @Setter
    private String syushrgkkeiHnykSyuruiKbn;
}
