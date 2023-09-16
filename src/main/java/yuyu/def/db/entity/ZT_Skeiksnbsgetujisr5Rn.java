package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr5Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル５（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr5Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr5Rn
 * @see     PKZT_Skeiksnbsgetujisr5Rn
 * @see     QZT_Skeiksnbsgetujisr5Rn
 * @see     GenQZT_Skeiksnbsgetujisr5Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr5Rn extends GenZT_Skeiksnbsgetujisr5Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr5Rn() {
    }

    public ZT_Skeiksnbsgetujisr5Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
