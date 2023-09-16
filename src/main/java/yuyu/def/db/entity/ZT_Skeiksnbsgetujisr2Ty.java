package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu2Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr2Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr2Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル２（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr2Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr2Ty
 * @see     PKZT_Skeiksnbsgetujisr2Ty
 * @see     QZT_Skeiksnbsgetujisr2Ty
 * @see     GenQZT_Skeiksnbsgetujisr2Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr2Ty extends GenZT_Skeiksnbsgetujisr2Ty implements SinkeiyakuSeiritu2Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr2Ty() {
    }

    public ZT_Skeiksnbsgetujisr2Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
