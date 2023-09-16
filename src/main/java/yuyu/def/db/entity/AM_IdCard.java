package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKAM_IdCard;
import yuyu.def.db.mapping.GenAM_IdCard;
import yuyu.def.db.meta.GenQAM_IdCard;
import yuyu.def.db.meta.QAM_IdCard;

/**
 * ＩＤカードマスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAM_IdCard} の JavaDoc を参照してください。
 * @see     GenAM_IdCard
 * @see     PKAM_IdCard
 * @see     QAM_IdCard
 * @see     GenQAM_IdCard
 */
@Entity
public class AM_IdCard extends GenAM_IdCard {

    private static final long serialVersionUID = 1L;

    public AM_IdCard() {
    }

    public AM_IdCard(String pIdkbn, String pIdcd) {
        super(pIdkbn,pIdcd);
    }

}

