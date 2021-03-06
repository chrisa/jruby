GEM_OPTIONS = '--no-ri --no-rdoc'

task :install_build_gems => :install_gems do
  gem_install(BUILD_GEMS, GEM_OPTIONS)
end

task :install_gems do
  gem_install(COMPLETE_JAR_GEMS, "#{GEM_OPTIONS} --ignore-dependencies")
end

task :install_dist_gems do
  gem_install(COMPLETE_JAR_GEMS, "--ignore-dependencies") do
    sysproperty :key => "jruby.home", :value => DIST_STAGE_BIN_DIR
  end
end
