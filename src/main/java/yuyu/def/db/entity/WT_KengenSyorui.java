package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKWT_KengenSyorui;
import yuyu.def.db.mapping.GenWT_KengenSyorui;
import yuyu.def.db.meta.GenQWT_KengenSyorui;
import yuyu.def.db.meta.QWT_KengenSyorui;

/**
 * 権限明細（書類）テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenWT_KengenSyorui} の JavaDoc を参照してください。
 * @see     GenWT_KengenSyorui
 * @see     PKWT_KengenSyorui
 * @see     QWT_KengenSyorui
 * @see     GenQWT_KengenSyorui
 */
@Entity
public class WT_KengenSyorui extends GenWT_KengenSyorui {

    private static final long serialVersionUID = 1L;

    public WT_KengenSyorui() {
    }

    public WT_KengenSyorui(String pRoleCd, String pTorikomiSyoruiCd) {
        super(pRoleCd, pTorikomiSyoruiCd);
    }

}
