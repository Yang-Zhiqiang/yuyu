package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenIM_KhHubiNaiyou;


/**
 * 契約保全不備内容マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhHubiNaiyou} の JavaDoc を参照してください。<br />
 * @see     GenIM_KhHubiNaiyou<br />
 * @see     PKIM_KhHubiNaiyou<br />
 * @see     QIM_KhHubiNaiyou<br />
 * @see     GenQIM_KhHubiNaiyou<br />
 */
@Entity
public class IM_KhHubiNaiyou extends GenIM_KhHubiNaiyou {

    private static final long serialVersionUID = 1L;

    public IM_KhHubiNaiyou() {
    }

    public IM_KhHubiNaiyou(String pJimutetuzukicd,C_SyoruiCdKbn pSyoruiCd,String pHubinaiyoucd) {
        super(pJimutetuzukicd,pSyoruiCd,pHubinaiyoucd);
    }



}

