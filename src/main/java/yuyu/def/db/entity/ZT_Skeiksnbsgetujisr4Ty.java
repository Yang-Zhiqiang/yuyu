package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu4Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr4Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr4Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル４（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr4Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr4Ty
 * @see     PKZT_Skeiksnbsgetujisr4Ty
 * @see     QZT_Skeiksnbsgetujisr4Ty
 * @see     GenQZT_Skeiksnbsgetujisr4Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr4Ty extends GenZT_Skeiksnbsgetujisr4Ty implements SinkeiyakuSeiritu4Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr4Ty() {
    }

    public ZT_Skeiksnbsgetujisr4Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
