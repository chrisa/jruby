require 'test/minirunit'

# Normal objects
o1 = "hey"
o2 = "ho"
id1 = o1.object_id
id2 = o2.object_id
test_equal(o1, ObjectSpace._id2ref(id1))
test_equal(o2, ObjectSpace._id2ref(id2))

# Fixnums
o1 = 17
o2 = 100001
id1 = o1.object_id
id2 = o2.object_id
test_equal(o1, ObjectSpace._id2ref(id1))
test_equal(o2, ObjectSpace._id2ref(id2))

test_equal(1, 0.object_id)
test_equal(3, 1.object_id)
test_equal(201, 100.object_id)
test_equal(-1, -1.object_id)
test_equal(-19, -10.object_id)

test_equal(0, false.object_id)
test_equal(2, true.object_id)
test_equal(4, nil.object_id)

test_equal(false, ObjectSpace._id2ref(0))
test_equal(true, ObjectSpace._id2ref(2))
test_equal(nil, ObjectSpace._id2ref(4))

if (defined?(JRUBY_VERSION))
  require 'jruby'
  orig_obj_space = JRuby.objectspace
  begin

    JRuby.objectspace = false
    test_equal(false, JRuby.objectspace)
    JRuby.objectspace = true
    test_equal(true, JRuby.objectspace)

    # JRUBY-4330
    obj = "wahoo"
    id_with_objectspace = obj.object_id
    JRuby.objectspace = false
    id_without_objectspace = obj.object_id
    test_equal(id_with_objectspace, id_without_objectspace)

  ensure
    JRuby.objectspace = orig_obj_space
  end
end
