package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu3Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr3Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr3Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル３（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr3Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr3Ty
 * @see     PKZT_Skeiksnbsgetujisr3Ty
 * @see     QZT_Skeiksnbsgetujisr3Ty
 * @see     GenQZT_Skeiksnbsgetujisr3Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr3Ty extends GenZT_Skeiksnbsgetujisr3Ty implements SinkeiyakuSeiritu3Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr3Ty() {
    }

    public ZT_Skeiksnbsgetujisr3Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
