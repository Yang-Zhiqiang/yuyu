package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_SiRireki;


/**
 * 支払履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiRireki} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiRireki<br />
 * @see     PKJT_SiRireki<br />
 * @see     QJT_SiRireki<br />
 * @see     GenQJT_SiRireki<br />
 */
@Entity
public class JT_SiRireki extends GenJT_SiRireki {

    private static final long serialVersionUID = 1L;

    public JT_SiRireki() {
    }

    public JT_SiRireki(String pSkno,String pSyono,String pShrsikibetukey) {
        super(pSkno,pSyono,pShrsikibetukey);
    }



    private JT_SkKihon jT_SkKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_SiRireki.SKNO  , referencedColumnName=JT_SkKihon.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_SiRireki.SYONO  , referencedColumnName=JT_SkKihon.SYONO, insertable=false, updatable=false)
    })
    public JT_SkKihon getSkKihon() {
        return jT_SkKihon;
    }

    public void setSkKihon(JT_SkKihon pJT_SkKihon) {
        this.jT_SkKihon = pJT_SkKihon;
    }

}

