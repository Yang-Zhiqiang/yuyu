package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAM_HonyakutsgSosikiCd;
import yuyu.def.db.mapping.GenAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.GenQAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.QAM_HonyakutsgSosikiCd;

/**
 * 翻訳対象外組織コードマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_HonyakutsgSosikiCd} の JavaDoc を参照してください。
 * @see     GenAM_HonyakutsgSosikiCd
 * @see     PKAM_HonyakutsgSosikiCd
 * @see     QAM_HonyakutsgSosikiCd
 * @see     GenQAM_HonyakutsgSosikiCd
 */
@Entity
public class AM_HonyakutsgSosikiCd extends GenAM_HonyakutsgSosikiCd {

    private static final long serialVersionUID = 1L;

    public AM_HonyakutsgSosikiCd() {
    }

    public AM_HonyakutsgSosikiCd(String pSosikicd) {
        super(pSosikicd);
    }

}
