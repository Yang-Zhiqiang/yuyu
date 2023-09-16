package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr4Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル４（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr4Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr4Rn
 * @see     PKZT_Skeiksnbsgetujisr4Rn
 * @see     QZT_Skeiksnbsgetujisr4Rn
 * @see     GenQZT_Skeiksnbsgetujisr4Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr4Rn extends GenZT_Skeiksnbsgetujisr4Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr4Rn() {
    }

    public ZT_Skeiksnbsgetujisr4Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
