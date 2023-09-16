package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr2Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル２（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr2Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr2Rn
 * @see     PKZT_Skeiksnbsgetujisr2Rn
 * @see     QZT_Skeiksnbsgetujisr2Rn
 * @see     GenQZT_Skeiksnbsgetujisr2Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr2Rn extends GenZT_Skeiksnbsgetujisr2Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr2Rn() {
    }

    public ZT_Skeiksnbsgetujisr2Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
