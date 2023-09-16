package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import yuyu.def.db.mapping.GenJT_KoudosgJytGtKahi;


/**
 * 高度障害状態該当可否テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_KoudosgJytGtKahi} の JavaDoc を参照してください。<br />
 * @see     GenJT_KoudosgJytGtKahi<br />
 * @see     PKJT_KoudosgJytGtKahi<br />
 * @see     QJT_KoudosgJytGtKahi<br />
 * @see     GenQJT_KoudosgJytGtKahi<br />
 */
@Entity
public class JT_KoudosgJytGtKahi extends GenJT_KoudosgJytGtKahi {

    private static final long serialVersionUID = 1L;

    public JT_KoudosgJytGtKahi() {
    }

    public JT_KoudosgJytGtKahi(String pSkno,String pSyono,Integer pSeikyuurirekino) {
        super(pSkno,pSyono,pSeikyuurirekino);
    }



    private JT_Sk jT_Sk ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=JT_KoudosgJytGtKahi.SKNO  , referencedColumnName=JT_Sk.SKNO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgJytGtKahi.SYONO  , referencedColumnName=JT_Sk.SYONO, insertable=false, updatable=false),
        @JoinColumn(name=JT_KoudosgJytGtKahi.SEIKYUURIREKINO  , referencedColumnName=JT_Sk.SEIKYUURIREKINO, insertable=false, updatable=false)
    })
    public JT_Sk getSk() {
        return jT_Sk;
    }

    public void setSk(JT_Sk pJT_Sk) {
        this.jT_Sk = pJT_Sk;
    }

}

