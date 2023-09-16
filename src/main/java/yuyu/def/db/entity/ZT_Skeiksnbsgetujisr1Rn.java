package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr1Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル１（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr1Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr1Rn
 * @see     PKZT_Skeiksnbsgetujisr1Rn
 * @see     QZT_Skeiksnbsgetujisr1Rn
 * @see     GenQZT_Skeiksnbsgetujisr1Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr1Rn extends GenZT_Skeiksnbsgetujisr1Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr1Rn() {
    }

    public ZT_Skeiksnbsgetujisr1Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
