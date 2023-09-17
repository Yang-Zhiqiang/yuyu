package yuyu.def.biz.result.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import yuyu.def.classification.C_SyoruiCdKbn;

/**
 * 対象帳票情報Beanクラスです。<br />
 */
@AllArgsConstructor
public class TyouhyouInfosBySubSystemIdSyoriYmdRoleCdsSyoruiCdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter @Setter
    private C_SyoruiCdKbn syoruiCd;

    @Getter @Setter
    private String syoruinm;

    @Getter @Setter
    private String kensakuKey1;

    @Getter @Setter
    private Long aT_TyouhyouKensakuCount;

    @Getter @Setter
    private Long aT_TyouhyouOutputKengenCount;


}
