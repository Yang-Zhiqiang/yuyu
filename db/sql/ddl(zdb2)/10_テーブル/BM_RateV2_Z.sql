CREATE TABLE BM_RateV2_Z (
     palhokensyuruikigou                                CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ予定利率 */
     palpmencode                                        CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                 CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ払込回数 */
     palhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                  CHAR        (1)                                                       NOT NULL  ,  /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                      CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ保険期間 */
     palpharaikomikikan                                 CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                              CHAR        (2)                                                       NOT NULL  ,  /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* レート用通貨種類区分 */
     ratedai1hknkkn                                     CHAR        (2)                                                       NOT NULL  ,  /* レート用第１保険期間 */
     vrate00                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート００ */
     vrate01                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０１ */
     vrate02                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０２ */
     vrate03                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０３ */
     vrate04                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０４ */
     vrate05                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０５ */
     vrate06                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０６ */
     vrate07                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０７ */
     vrate08                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０８ */
     vrate09                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート０９ */
     vrate10                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１０ */
     vrate11                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１１ */
     vrate12                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１２ */
     vrate13                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１３ */
     vrate14                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１４ */
     vrate15                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１５ */
     vrate16                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１６ */
     vrate17                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１７ */
     vrate18                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１８ */
     vrate19                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート１９ */
     vrate20                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２０ */
     vrate21                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２１ */
     vrate22                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２２ */
     vrate23                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２３ */
     vrate24                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２４ */
     vrate25                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２５ */
     vrate26                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２６ */
     vrate27                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２７ */
     vrate28                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２８ */
     vrate29                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート２９ */
     vrate30                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３０ */
     vrate31                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３１ */
     vrate32                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３２ */
     vrate33                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３３ */
     vrate34                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３４ */
     vrate35                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３５ */
     vrate36                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３６ */
     vrate37                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３７ */
     vrate38                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３８ */
     vrate39                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート３９ */
     vrate40                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４０ */
     vrate41                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４１ */
     vrate42                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４２ */
     vrate43                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４３ */
     vrate44                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４４ */
     vrate45                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４５ */
     vrate46                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４６ */
     vrate47                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４７ */
     vrate48                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４８ */
     vrate49                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート４９ */
     vrate50                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５０ */
     vrate51                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５１ */
     vrate52                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５２ */
     vrate53                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５３ */
     vrate54                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５４ */
     vrate55                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５５ */
     vrate56                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５６ */
     vrate57                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５７ */
     vrate58                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５８ */
     vrate59                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート５９ */
     vrate60                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６０ */
     vrate61                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６１ */
     vrate62                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６２ */
     vrate63                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６３ */
     vrate64                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６４ */
     vrate65                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６５ */
     vrate66                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６６ */
     vrate67                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６７ */
     vrate68                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６８ */
     vrate69                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート６９ */
     vrate70                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７０ */
     vrate71                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７１ */
     vrate72                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７２ */
     vrate73                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７３ */
     vrate74                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７４ */
     vrate75                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７５ */
     vrate76                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７６ */
     vrate77                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７７ */
     vrate78                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７８ */
     vrate79                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート７９ */
     vrate80                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８０ */
     vrate81                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８１ */
     vrate82                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８２ */
     vrate83                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８３ */
     vrate84                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８４ */
     vrate85                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８５ */
     vrate86                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８６ */
     vrate87                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８７ */
     vrate88                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８８ */
     vrate89                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート８９ */
     vrate90                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９０ */
     vrate91                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９１ */
     vrate92                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９２ */
     vrate93                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９３ */
     vrate94                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９４ */
     vrate95                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９５ */
     vrate96                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９６ */
     vrate97                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９７ */
     vrate98                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９８ */
     vrate99                                            DECIMAL     (9,6)                                                               ,  /* Ｖレート９９ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE BM_RateV2_Z ADD CONSTRAINT PK_RateV2 PRIMARY KEY (
     palhokensyuruikigou                                      , /* ＰＡＬ保険種類記号 */
     palhokensyuruikigousdicode                               , /* ＰＡＬ保険種類記号世代コード */
     palyoteiriritu                                           , /* ＰＡＬ予定利率 */
     palpmencode                                              , /* ＰＡＬＰ免コード */
     palharaikomikaisuu                                       , /* ＰＡＬ払込回数 */
     palhhknsei                                               , /* ＰＡＬ被保険者性別 */
     palkeiyakujihhknnen                                      , /* ＰＡＬ契約時被保険者年令 */
     palsaimankihyouji                                        , /* ＰＡＬ才満期契約表示 */
     palhokenkikan                                            , /* ＰＡＬ保険期間 */
     palpharaikomikikan                                       , /* ＰＡＬＰ払込期間 */
     palannaihuyouriyuukbn                                    , /* ＰＡＬ案内不要理由区分 */
     ratetuukasyukbn                                          , /* レート用通貨種類区分 */
     ratedai1hknkkn                                             /* レート用第１保険期間 */
) ;
