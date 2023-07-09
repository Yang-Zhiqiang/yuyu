CREATE TABLE BM_Dairiten_Z (
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     drtennm                                            VARCHAR     (62)                                                                ,  /* 代理店名 */
     kanjidairitennm                                    VARCHAR     (62)                                                                ,  /* 漢字代理店名 */
     itakukeiyakuymd                                    VARCHAR     (8)                                                                 ,  /* 委託契約年月日 */
     itakukeiyakukaiyakuymd                             VARCHAR     (8)                                                                 ,  /* 委託契約解約年月日 */
     dairitentourokuymd                                 VARCHAR     (8)                                                                 ,  /* 代理店登録年月日 */
     daisinhidaisinkbn                                  VARCHAR     (1)                                                                 ,  /* 代申非代申区分 */
     drtkanrisosikicd1                                  VARCHAR     (7)                                                                 ,  /* 管理組織コード（１） */
     drtkanrisosikicd2                                  VARCHAR     (7)                                                                 ,  /* 管理組織コード（２） */
     drtkanrisosikicd3                                  VARCHAR     (7)                                                                 ,  /* 管理組織コード（３） */
     keisyousakidrtencd                                 VARCHAR     (7)                                                                 ,  /* 継承先代理店コード */
     ksymtdrtencd                                       VARCHAR     (7)                                                                 ,  /* 継承元代理店コード */
     dairitenkihontikucd                                VARCHAR     (8)                                                                 ,  /* 代理店基本地区コード */
     kanjidairitenkaijyuusyo                            VARCHAR     (126)                                                               ,  /* 漢字代理店下位住所 */
     dairitentelno                                      VARCHAR     (14)                                                                ,  /* 代理店電話番号 */
     dairitenfaxno                                      VARCHAR     (14)                                                                ,  /* 代理店ＦＡＸ番号 */
     oyadrtencd                                         VARCHAR     (7)                                                                 ,  /* 親代理店コード */
     dairitenkouryokukaisiymd                           VARCHAR     (8)                                                                 ,  /* 代理店効力開始年月日 */
     dairitenkouryokusyuuryouymd                        VARCHAR     (8)                                                                 ,  /* 代理店効力終了年月日 */
     kinyuucd                                           VARCHAR     (4)                                                                 ,  /* 金融機関コード */
     kinyuusitencd                                      VARCHAR     (4)                                                                 ,  /* 金融機関支店コード */
     drtenjimcd                                         VARCHAR     (4)                                                                 ,  /* 代理店事務所コード */
     daibosyuucd                                        VARCHAR     (6)                                                                 ,  /* 代表募集人コード */
     bntndrtencd                                        VARCHAR     (7)                                                                 ,  /* 分担相手代理店コード */
     bunwari                                            DECIMAL     (3)                                                                 ,  /* 分担割合 */
     tkrtkkinyuuknhyouji                                VARCHAR     (1)                                                                 ,  /* 特例地域金融機関表示 */
     kydsskkinyuuknhyouji                               VARCHAR     (1)                                                                 ,  /* 協同組織金融機関表示 */
     kydbosyuudairitenhyouji                            VARCHAR     (1)                                                                 ,  /* 共同募集代理店表示 */
     yuuseijimusyocd                                    VARCHAR     (6)                                                                 ,  /* 郵政事務所コード */
     toukatudairitencd                                  VARCHAR     (7)                                                                 ,  /* 統括代理店コード */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     mdhnschemedrtenhyouji                              VARCHAR     (1)                                                                 ,  /* 窓販スキーム代理店表示 */
     tykatukaiyoudrtenhyouji                            VARCHAR     (1)                                                                 ,  /* 直扱用代理店表示 */
     drtentrkno                                         VARCHAR     (13)                                                                ,  /* 代理店登録番号 */
     drtensyouhncdkami3x1                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１ */
     tsryshrkbntougetux1                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１ */
     tsryshrkbnyokugetux1                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１ */
     bntnptnkbnx1                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１ */
     drtensyouhncdkami3x2                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿２ */
     tsryshrkbntougetux2                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿２ */
     tsryshrkbnyokugetux2                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿２ */
     bntnptnkbnx2                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿２ */
     drtensyouhncdkami3x3                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿３ */
     tsryshrkbntougetux3                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿３ */
     tsryshrkbnyokugetux3                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿３ */
     bntnptnkbnx3                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿３ */
     drtensyouhncdkami3x4                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿４ */
     tsryshrkbntougetux4                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿４ */
     tsryshrkbnyokugetux4                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿４ */
     bntnptnkbnx4                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿４ */
     drtensyouhncdkami3x5                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿５ */
     tsryshrkbntougetux5                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿５ */
     tsryshrkbnyokugetux5                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿５ */
     bntnptnkbnx5                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿５ */
     drtensyouhncdkami3x6                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿６ */
     tsryshrkbntougetux6                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿６ */
     tsryshrkbnyokugetux6                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿６ */
     bntnptnkbnx6                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿６ */
     drtensyouhncdkami3x7                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿７ */
     tsryshrkbntougetux7                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿７ */
     tsryshrkbnyokugetux7                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿７ */
     bntnptnkbnx7                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿７ */
     drtensyouhncdkami3x8                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿８ */
     tsryshrkbntougetux8                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿８ */
     tsryshrkbnyokugetux8                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿８ */
     bntnptnkbnx8                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿８ */
     drtensyouhncdkami3x9                               VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿９ */
     tsryshrkbntougetux9                                VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿９ */
     tsryshrkbnyokugetux9                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿９ */
     bntnptnkbnx9                                       VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿９ */
     drtensyouhncdkami3x10                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１０ */
     tsryshrkbntougetux10                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１０ */
     tsryshrkbnyokugetux10                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１０ */
     bntnptnkbnx10                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１０ */
     drtensyouhncdkami3x11                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１１ */
     tsryshrkbntougetux11                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１１ */
     tsryshrkbnyokugetux11                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１１ */
     bntnptnkbnx11                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１１ */
     drtensyouhncdkami3x12                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１２ */
     tsryshrkbntougetux12                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１２ */
     tsryshrkbnyokugetux12                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１２ */
     bntnptnkbnx12                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１２ */
     drtensyouhncdkami3x13                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１３ */
     tsryshrkbntougetux13                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１３ */
     tsryshrkbnyokugetux13                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１３ */
     bntnptnkbnx13                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１３ */
     drtensyouhncdkami3x14                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１４ */
     tsryshrkbntougetux14                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１４ */
     tsryshrkbnyokugetux14                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１４ */
     bntnptnkbnx14                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１４ */
     drtensyouhncdkami3x15                              VARCHAR     (3)                                                                 ,  /* 代理店商品コード上３桁＿１５ */
     tsryshrkbntougetux15                               VARCHAR     (1)                                                                 ,  /* 手数料支払区分（当月）＿１５ */
     tsryshrkbnyokugetux15                              VARCHAR     (1)                                                                 ,  /* 手数料支払区分（翌月）＿１５ */
     bntnptnkbnx15                                      VARCHAR     (1)                                                                 ,  /* 分担パターン区分＿１５ */
     tsrybntnaitedrtencdx1                              VARCHAR     (7)                                                                 ,  /* 手数料分担相手代理店コード＿１ */
     tsrybntnwarix1                                     DECIMAL     (3,2)                                                               ,  /* 手数料分担割合＿１ */
     tsrybntnaitedrtencdx2                              VARCHAR     (7)                                                                 ,  /* 手数料分担相手代理店コード＿２ */
     tsrybntnwarix2                                     DECIMAL     (3,2)                                                               ,  /* 手数料分担割合＿２ */
     tsrybntnaitedrtencdx3                              VARCHAR     (7)                                                                 ,  /* 手数料分担相手代理店コード＿３ */
     tsrybntnwarix3                                     DECIMAL     (3,2)                                                               ,  /* 手数料分担割合＿３ */
     tsrybntnaitedrtencdx4                              VARCHAR     (7)                                                                 ,  /* 手数料分担相手代理店コード＿４ */
     tsrybntnwarix4                                     DECIMAL     (3,2)                                                               ,  /* 手数料分担割合＿４ */
     hnsituhykranktougetu                               DECIMAL     (3)                                                                 ,  /* 品質評価ランク（当月） */
     hnsituhykrankyokugetu                              DECIMAL     (3)                                                                    /* 品質評価ランク（翌月） */
)
;

ALTER TABLE BM_Dairiten_Z ADD CONSTRAINT PK_Dairiten PRIMARY KEY (
     drtencd                                                    /* 代理店コード */
) ;

CREATE INDEX IX1_Dairiten ON BM_Dairiten_Z (
     kinyuucd                                                 , /* 金融機関コード */
     drtenjimcd                                                 /* 代理店事務所コード */
) ;

CREATE INDEX IX2_Dairiten ON BM_Dairiten_Z (
     drtencd                                                  , /* 代理店コード */
     kinyuucd                                                 , /* 金融機関コード */
     dairitenkouryokukaisiymd                                 , /* 代理店効力開始年月日 */
     dairitenkouryokusyuuryouymd                                /* 代理店効力終了年月日 */
) ;

CREATE INDEX IX3_Dairiten ON BM_Dairiten_Z (
     oyadrtencd                                               , /* 親代理店コード */
     drtenjimcd                                                 /* 代理店事務所コード */
) ;
