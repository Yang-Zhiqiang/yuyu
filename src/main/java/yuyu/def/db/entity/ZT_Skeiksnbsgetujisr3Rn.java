package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr3Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル３（連） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr3Rn} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr3Rn
 * @see     PKZT_Skeiksnbsgetujisr3Rn
 * @see     QZT_Skeiksnbsgetujisr3Rn
 * @see     GenQZT_Skeiksnbsgetujisr3Rn
 */
@Entity
public class ZT_Skeiksnbsgetujisr3Rn extends GenZT_Skeiksnbsgetujisr3Rn {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr3Rn() {
    }

    public ZT_Skeiksnbsgetujisr3Rn(String pZrnktgysyono) {
        super(pZrnktgysyono);
    }

}
