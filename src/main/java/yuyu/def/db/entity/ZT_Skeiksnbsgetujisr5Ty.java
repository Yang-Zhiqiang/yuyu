package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.suuri.srcommon.SinkeiyakuSeiritu5Param;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.mapping.GenZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr5Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr5Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル５（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_Skeiksnbsgetujisr5Ty} の JavaDoc を参照してください。
 * @see     GenZT_Skeiksnbsgetujisr5Ty
 * @see     PKZT_Skeiksnbsgetujisr5Ty
 * @see     QZT_Skeiksnbsgetujisr5Ty
 * @see     GenQZT_Skeiksnbsgetujisr5Ty
 */
@Entity
public class ZT_Skeiksnbsgetujisr5Ty extends GenZT_Skeiksnbsgetujisr5Ty implements SinkeiyakuSeiritu5Param {

    private static final long serialVersionUID = 1L;

    public ZT_Skeiksnbsgetujisr5Ty() {
    }

    public ZT_Skeiksnbsgetujisr5Ty(String pZtyktgysyono) {
        super(pZtyktgysyono);
    }

}
