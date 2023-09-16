package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr6Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr6Rn
 * @see     PKZT_Skeiksnbsgetujisr6Rn
 * @see     QZT_Skeiksnbsgetujisr6Rn
 * @see     GenQZT_Skeiksnbsgetujisr6Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr6Rn extends GenZT_Skeiksnbsgetujisr6Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr6Rn() {
    }

    public ZT_Skeiksnbsgetujisr6Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
