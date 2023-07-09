CREATE TABLE ZT_KouzaHrkmTuutiTy_Z (
     ztysyoruicd                                        VARCHAR     (5)                                                                 ,  /* （中継用）書類コード */
     ztyhassoukbn                                       VARCHAR     (1)                                                                 ,  /* （中継用）発送区分 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztytyouhyouymdkj                                   VARCHAR     (24)                                                                ,  /* （中継用）帳票作成日（漢字） */
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztysikibetuno                                      VARCHAR     (20)                                                      NOT NULL  ,  /* （中継用）識別番号 */
     ztyyobiv14                                         VARCHAR     (14)                                                                ,  /* （中継用）予備項目Ｖ１４ */
     ztyansyuyouyobin10                                 VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０ */
     ztyshskyno                                         VARCHAR     (7)                                                                 ,  /* （中継用）送付先郵便番号 */
     ztyshskadr1kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所１（漢字） */
     ztyshskadr2kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所２（漢字） */
     ztyshskadr3kj                                      VARCHAR     (62)                                                                ,  /* （中継用）送付先住所３（漢字） */
     ztyshsnmkj                                         VARCHAR     (32)                                                                ,  /* （中継用）送付先名（漢字） */
     ztyyobiv43                                         VARCHAR     (43)                                                                ,  /* （中継用）予備項目Ｖ４３ */
     ztyansyuyouyobin10x2                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿２ */
     ztytawsosikikj                                     VARCHAR     (32)                                                                ,  /* （中継用）問合せ先組織名（漢字） */
     ztytawyno                                          VARCHAR     (8)                                                                 ,  /* （中継用）問合せ先郵便番号 */
     ztytawadr1kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所１（漢字） */
     ztytawadr2kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所２（漢字） */
     ztytawadr3kj                                       VARCHAR     (32)                                                                ,  /* （中継用）問合せ先住所３（漢字） */
     ztytawtelnov14                                     VARCHAR     (14)                                                                ,  /* （中継用）問合せ先電話番号Ｖ１４ */
     ztytawteluktkkanou1                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間１ */
     ztytawteluktkkanou2                                VARCHAR     (52)                                                                ,  /* （中継用）問合せ先電話受付可能時間２ */
     ztydai2tawsosikinmkj                               VARCHAR     (32)                                                                ,  /* （中継用）第２問合せ先組織名（漢字） */
     ztydai2tawtelno                                    VARCHAR     (14)                                                                ,  /* （中継用）第２問合せ先電話番号 */
     ztysclatosyono                                     VARCHAR     (11)                                                                ,  /* （中継用）スクランブル後証券番号 */
     ztysakunm15keta                                    VARCHAR     (15)                                                                ,  /* （中継用）作成番号（１５桁） */
     ztyyobiv62                                         VARCHAR     (62)                                                                ,  /* （中継用）予備項目Ｖ６２ */
     ztyansyuyouyobin10x3                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿３ */
     ztytuutisakuseiymdV11                              VARCHAR     (24)                                                                ,  /* （中継用）通知作成年月日Ｖ１１ */
     ztysyono2                                          VARCHAR     (11)                                                                ,  /* （中継用）証券番号２ */
     ztyhrkmymdseireki                                  VARCHAR     (24)                                                                ,  /* （中継用）振込日（西暦） */
     ztyshrgk                                           VARCHAR     (13)                                                                ,  /* （中継用）支払金額 */
     ztyshririyuu1                                      VARCHAR     (66)                                                                ,  /* （中継用）支払理由１ */
     ztyshririyuu2                                      VARCHAR     (66)                                                                ,  /* （中継用）支払理由２ */
     ztyshririyuu3                                      VARCHAR     (66)                                                                ,  /* （中継用）支払理由３ */
     ztysiteikouza1                                     VARCHAR     (66)                                                                ,  /* （中継用）指定口座１ */
     ztysiteikouza2                                     VARCHAR     (66)                                                                ,  /* （中継用）指定口座２ */
     ztysiteikouza3                                     VARCHAR     (66)                                                                ,  /* （中継用）指定口座３ */
     ztysiteikouza4                                     VARCHAR     (66)                                                                ,  /* （中継用）指定口座４ */
     ztysiteikouza5                                     VARCHAR     (66)                                                                ,  /* （中継用）指定口座５ */
     ztyyobiv116                                        VARCHAR     (116)                                                               ,  /* （中継用）予備項目Ｖ１１６ */
     ztyansyuyouyobin10x4                               VARCHAR     (10)                                                                ,  /* （中継用）案内収納用予備項目Ｎ１０＿４ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE ZT_KouzaHrkmTuutiTy_Z ADD CONSTRAINT PK_KouzaHrkmTuutiTy PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysikibetuno                                              /* （中継用）識別番号 */
) ;
