package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu6Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr6Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr6Ty
 * @see     PKZT_Skeiksnbsgetujisr6Ty
 * @see     QZT_Skeiksnbsgetujisr6Ty
 * @see     GenQZT_Skeiksnbsgetujisr6Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr6Ty extends GenZT_Skeiksnbsgetujisr6Ty implements SinkeiyakuSeiritu6Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr6Ty() {
    }

    public ZT_Skeiksnbsgetujisr6Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
