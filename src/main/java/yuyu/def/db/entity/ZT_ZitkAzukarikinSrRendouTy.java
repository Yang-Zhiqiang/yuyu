package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.mapping.GenZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.GenQZT_ZitkAzukarikinSrRendouTy;
import yuyu.def.db.meta.QZT_ZitkAzukarikinSrRendouTy;

/**
 * 税適預り金数理連動Ｆテーブル（中） エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenZT_ZitkAzukarikinSrRendouTy} の JavaDoc を参照してください。
 * @see     GenZT_ZitkAzukarikinSrRendouTy
 * @see     PKZT_ZitkAzukarikinSrRendouTy
 * @see     QZT_ZitkAzukarikinSrRendouTy
 * @see     GenQZT_ZitkAzukarikinSrRendouTy
 */
@Entity
public class ZT_ZitkAzukarikinSrRendouTy extends GenZT_ZitkAzukarikinSrRendouTy {

    private static final long serialVersionUID = 1L;

    public ZT_ZitkAzukarikinSrRendouTy() {
    }

    public ZT_ZitkAzukarikinSrRendouTy(Integer pZtysequenceno) {
        super(pZtysequenceno);
    }

}
