package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu1Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr1Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr1Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル１（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr1Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr1Ty
 * @see     PKZT_Skeiksnbsgetujisr1Ty
 * @see     QZT_Skeiksnbsgetujisr1Ty
 * @see     GenQZT_Skeiksnbsgetujisr1Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr1Ty extends GenZT_Skeiksnbsgetujisr1Ty implements SinkeiyakuSeiritu1Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr1Ty() {
    }

    public ZT_Skeiksnbsgetujisr1Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
