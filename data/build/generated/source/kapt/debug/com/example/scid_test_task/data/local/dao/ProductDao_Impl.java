package com.example.scid_test_task.data.local.dao;

import androidx.annotation.NonNull;
import androidx.paging.PagingSource;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomRawQuery;
import androidx.room.paging.LimitOffsetPagingSource;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteStatement;
import com.example.scid_test_task.data.local.entity.ProductEntity;
import java.lang.Class;
import java.lang.Integer;
import java.lang.NullPointerException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation", "removal"})
public final class ProductDao_Impl implements ProductDao {
  private final RoomDatabase __db;

  private final EntityInsertAdapter<ProductEntity> __insertAdapterOfProductEntity;

  public ProductDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertAdapterOfProductEntity = new EntityInsertAdapter<ProductEntity>() {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `products` (`id`,`title`,`price`,`description`,`category`,`image`,`ratingRate`,`ratingCount`,`timestamp`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SQLiteStatement statement,
          @NonNull final ProductEntity entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindText(2, entity.getTitle());
        }
        statement.bindDouble(3, entity.getPrice());
        if (entity.getDescription() == null) {
          statement.bindNull(4);
        } else {
          statement.bindText(4, entity.getDescription());
        }
        if (entity.getCategory() == null) {
          statement.bindNull(5);
        } else {
          statement.bindText(5, entity.getCategory());
        }
        if (entity.getImage() == null) {
          statement.bindNull(6);
        } else {
          statement.bindText(6, entity.getImage());
        }
        statement.bindDouble(7, entity.getRatingRate());
        statement.bindLong(8, entity.getRatingCount());
        statement.bindLong(9, entity.getTimestamp());
      }
    };
  }

  @Override
  public Object insertProducts(final List<ProductEntity> products,
      final Continuation<? super Unit> $completion) {
    if (products == null) throw new NullPointerException();
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      __insertAdapterOfProductEntity.insert(_connection, products);
      return Unit.INSTANCE;
    }, $completion);
  }

  @Override
  public PagingSource<Integer, ProductEntity> getAllProducts(final String category) {
    final String _sql = "SELECT * FROM products WHERE (? IS NULL OR category = ?) ORDER BY timestamp DESC";
    final RoomRawQuery _rawQuery = new RoomRawQuery(_sql, new Function1<SQLiteStatement, Unit>() {
      @Override
      @NonNull
      public Unit invoke(@NonNull final SQLiteStatement _stmt) {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        _argIndex = 2;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        return Unit.INSTANCE;
      }
    });
    return new LimitOffsetPagingSource<ProductEntity>(_rawQuery, __db, "products") {
      @Override
      protected Object convertRows(final RoomRawQuery limitOffsetQuery, final int itemCount,
          final Continuation<? super List<? extends ProductEntity>> $completion) {
        return DBUtil.performSuspending(__db, true, false, (_connection) -> {
          final SQLiteStatement _stmt = _connection.prepare(limitOffsetQuery.getSql());
          limitOffsetQuery.getBindingFunction().invoke(_stmt);
          try {
            final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
            final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
            final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
            final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
            final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
            final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
            final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
            final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
            final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
            final List<ProductEntity> _result = new ArrayList<ProductEntity>();
            while (_stmt.step()) {
              final ProductEntity _item;
              final int _tmpId;
              _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
              final String _tmpTitle;
              if (_stmt.isNull(_columnIndexOfTitle)) {
                _tmpTitle = null;
              } else {
                _tmpTitle = _stmt.getText(_columnIndexOfTitle);
              }
              final double _tmpPrice;
              _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
              final String _tmpDescription;
              if (_stmt.isNull(_columnIndexOfDescription)) {
                _tmpDescription = null;
              } else {
                _tmpDescription = _stmt.getText(_columnIndexOfDescription);
              }
              final String _tmpCategory;
              if (_stmt.isNull(_columnIndexOfCategory)) {
                _tmpCategory = null;
              } else {
                _tmpCategory = _stmt.getText(_columnIndexOfCategory);
              }
              final String _tmpImage;
              if (_stmt.isNull(_columnIndexOfImage)) {
                _tmpImage = null;
              } else {
                _tmpImage = _stmt.getText(_columnIndexOfImage);
              }
              final double _tmpRatingRate;
              _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
              final int _tmpRatingCount;
              _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
              final long _tmpTimestamp;
              _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
              _item = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
              _result.add(_item);
            }
            return _result;
          } finally {
            _stmt.close();
          }
        }, $completion);
      }
    };
  }

  @Override
  public Object getProductCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM products";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final Integer _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getProductCountByCategory(final String category,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM products WHERE category = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        final Integer _result;
        if (_stmt.step()) {
          final Integer _tmp;
          if (_stmt.isNull(0)) {
            _tmp = null;
          } else {
            _tmp = (int) (_stmt.getLong(0));
          }
          _result = _tmp;
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getProductById(final int id,
      final Continuation<? super ProductEntity> $completion) {
    final String _sql = "SELECT * FROM products WHERE id = ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final ProductEntity _result;
        if (_stmt.step()) {
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _result = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
        } else {
          _result = null;
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getCategories(final Continuation<? super List<String>> $completion) {
    final String _sql = "SELECT DISTINCT category FROM products";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final List<String> _result = new ArrayList<String>();
        while (_stmt.step()) {
          final String _item;
          if (_stmt.isNull(0)) {
            _item = null;
          } else {
            _item = _stmt.getText(0);
          }
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getProductsPaged(final int limit, final int offset,
      final Continuation<? super List<ProductEntity>> $completion) {
    final String _sql = "SELECT * FROM products ORDER BY timestamp DESC LIMIT ? OFFSET ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, limit);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, offset);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<ProductEntity> _result = new ArrayList<ProductEntity>();
        while (_stmt.step()) {
          final ProductEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getProductsByCategoryPaged(final String category, final int limit, final int offset,
      final Continuation<? super List<ProductEntity>> $completion) {
    final String _sql = "SELECT * FROM products WHERE category = ? ORDER BY timestamp DESC LIMIT ? OFFSET ?";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, limit);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, offset);
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<ProductEntity> _result = new ArrayList<ProductEntity>();
        while (_stmt.step()) {
          final ProductEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getAllProductsList(final Continuation<? super List<ProductEntity>> $completion) {
    final String _sql = "SELECT * FROM products ORDER BY timestamp DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<ProductEntity> _result = new ArrayList<ProductEntity>();
        while (_stmt.step()) {
          final ProductEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object getProductsByCategory(final String category,
      final Continuation<? super List<ProductEntity>> $completion) {
    final String _sql = "SELECT * FROM products WHERE category = ? ORDER BY timestamp DESC";
    return DBUtil.performSuspending(__db, true, false, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        final int _columnIndexOfId = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "id");
        final int _columnIndexOfTitle = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "title");
        final int _columnIndexOfPrice = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "price");
        final int _columnIndexOfDescription = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "description");
        final int _columnIndexOfCategory = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "category");
        final int _columnIndexOfImage = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "image");
        final int _columnIndexOfRatingRate = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingRate");
        final int _columnIndexOfRatingCount = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "ratingCount");
        final int _columnIndexOfTimestamp = SQLiteStatementUtil.getColumnIndexOrThrow(_stmt, "timestamp");
        final List<ProductEntity> _result = new ArrayList<ProductEntity>();
        while (_stmt.step()) {
          final ProductEntity _item;
          final int _tmpId;
          _tmpId = (int) (_stmt.getLong(_columnIndexOfId));
          final String _tmpTitle;
          if (_stmt.isNull(_columnIndexOfTitle)) {
            _tmpTitle = null;
          } else {
            _tmpTitle = _stmt.getText(_columnIndexOfTitle);
          }
          final double _tmpPrice;
          _tmpPrice = _stmt.getDouble(_columnIndexOfPrice);
          final String _tmpDescription;
          if (_stmt.isNull(_columnIndexOfDescription)) {
            _tmpDescription = null;
          } else {
            _tmpDescription = _stmt.getText(_columnIndexOfDescription);
          }
          final String _tmpCategory;
          if (_stmt.isNull(_columnIndexOfCategory)) {
            _tmpCategory = null;
          } else {
            _tmpCategory = _stmt.getText(_columnIndexOfCategory);
          }
          final String _tmpImage;
          if (_stmt.isNull(_columnIndexOfImage)) {
            _tmpImage = null;
          } else {
            _tmpImage = _stmt.getText(_columnIndexOfImage);
          }
          final double _tmpRatingRate;
          _tmpRatingRate = _stmt.getDouble(_columnIndexOfRatingRate);
          final int _tmpRatingCount;
          _tmpRatingCount = (int) (_stmt.getLong(_columnIndexOfRatingCount));
          final long _tmpTimestamp;
          _tmpTimestamp = _stmt.getLong(_columnIndexOfTimestamp);
          _item = new ProductEntity(_tmpId,_tmpTitle,_tmpPrice,_tmpDescription,_tmpCategory,_tmpImage,_tmpRatingRate,_tmpRatingCount,_tmpTimestamp);
          _result.add(_item);
        }
        return _result;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object clearProducts(final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM products";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @Override
  public Object clearProductsByCategory(final String category,
      final Continuation<? super Unit> $completion) {
    final String _sql = "DELETE FROM products WHERE category = ?";
    return DBUtil.performSuspending(__db, false, true, (_connection) -> {
      final SQLiteStatement _stmt = _connection.prepare(_sql);
      try {
        int _argIndex = 1;
        if (category == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindText(_argIndex, category);
        }
        _stmt.step();
        return Unit.INSTANCE;
      } finally {
        _stmt.close();
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
