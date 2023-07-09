CREATE TABLE IT_KrkknSeibiTokusokuInfo_Z (
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     krkno                                              DECIMAL     (5)                                                       NOT NULL  ,  /* 仮受番号 */
     atesakisosikicd                                    VARCHAR     (7)                                                                 ,  /* 宛先組織コード */
     atesakibusitucd                                    VARCHAR     (3)                                                                 ,  /* 宛先部・室コード */
     tantocd                                            VARCHAR     (1)                                                                 ,  /* 担当コード */
     kyknmkj                                            VARCHAR     (32)                                                                ,  /* 契約者名（漢字） */
     tyoukimiseibikrkumu                                VARCHAR     (1)                                                                 ,  /* 長期未整備仮受金有無 */
     hukusuukrkumu                                      VARCHAR     (1)                                                                 ,  /* 複数仮受金有無 */
     krkkeijyoymd                                       VARCHAR     (8)                                                                 ,  /* 仮受計上処理日 */
     krkgk                                              DECIMAL     (13)                                                                ,  /* 仮受金額 */
     krkgk$                                             VARCHAR     (10)                                                                ,  /* 仮受金額(通貨型) */
     krkriyuukbn                                        VARCHAR     (2)                                                                 ,  /* 仮受理由区分 */
     nyknaiyoukbn                                       VARCHAR     (2)                                                                 ,  /* 入金内容区分 */
     nykkeiro                                           VARCHAR     (2)                                                                 ,  /* 入金経路 */
     jyuutouym                                          VARCHAR     (6)                                                                 ,  /* 充当年月 */
     jyutoukaisuuy                                      DECIMAL     (2)                                                                 ,  /* 充当回数（年） */
     jyutoukaisuum                                      DECIMAL     (2)                                                                 ,  /* 充当回数（月） */
     ryosyuymd                                          VARCHAR     (8)                                                                 ,  /* 領収日 */
     krkjhrkkaisuu                                      VARCHAR     (2)                                                                 ,  /* 仮受時払込回数 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_KrkknSeibiTokusokuInfo_Z ADD CONSTRAINT PK_KrkknSeibiTokusokuInfo PRIMARY KEY (
     syono                                                    , /* 証券番号 */
     krkno                                                      /* 仮受番号 */
) ;
