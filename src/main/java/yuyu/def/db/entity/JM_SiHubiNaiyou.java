package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.mapping.GenJM_SiHubiNaiyou;


/**
 * 支払不備内容マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SiHubiNaiyou} の JavaDoc を参照してください。<br />
 * @see     GenJM_SiHubiNaiyou<br />
 * @see     PKJM_SiHubiNaiyou<br />
 * @see     QJM_SiHubiNaiyou<br />
 * @see     GenQJM_SiHubiNaiyou<br />
 */
@Entity
public class JM_SiHubiNaiyou extends GenJM_SiHubiNaiyou {

    private static final long serialVersionUID = 1L;

    public JM_SiHubiNaiyou() {
    }

    public JM_SiHubiNaiyou(String pJimutetuzukicd,C_SyoruiCdKbn pSyoruiCd,String pHubinaiyoucd) {
        super(pJimutetuzukicd,pSyoruiCd,pHubinaiyoucd);
    }



}

