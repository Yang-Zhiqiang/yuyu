package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_GeninKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.id.PKJM_SiinHantei;
import yuyu.def.db.mapping.GenJM_SiinHantei;
import yuyu.def.db.meta.GenQJM_SiinHantei;
import yuyu.def.db.meta.QJM_SiinHantei;

/**
 * 死因判定マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJM_SiinHantei} の JavaDoc を参照してください。
 * @see     GenJM_SiinHantei
 * @see     PKJM_SiinHantei
 * @see     QJM_SiinHantei
 * @see     GenQJM_SiinHantei
 */
@Entity
public class JM_SiinHantei extends GenJM_SiinHantei {

    private static final long serialVersionUID = 1L;

    public JM_SiinHantei() {
    }

    public JM_SiinHantei(
        C_GeninKbn pSiboukariuketukejigeninkbn,
        C_GeninKbn pSeikyuuuketukejigeninkbn,
        C_UmuKbn pKansensyouumukbn,
        C_UmuKbn pSaigaikanouseiumukbn,
        C_UmuKbn pHusyounosiumukbn,
        C_UmuKbn pSateikaksaigaikanouseikbn,
        C_UmuKbn pSateikakhusyousikbn
        ) {
        super(
            pSiboukariuketukejigeninkbn,
            pSeikyuuuketukejigeninkbn,
            pKansensyouumukbn,
            pSaigaikanouseiumukbn,
            pHusyounosiumukbn,
            pSateikaksaigaikanouseikbn,
            pSateikakhusyousikbn
            );
    }

}
