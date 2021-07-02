
Pod::Spec.new do |s|
  s.name         = "RNBuriedPoint"
  s.version      = "1.0.0"
  s.summary      = "RNBuriedPoint"
  s.description  = <<-DESC
                  RNBuriedPoint
                   DESC
  s.homepage     = "https://github.com/qzslz/buried-point.git"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/qzslz/buried-point.git", :tag => "master" }
  s.source_files  = "ios/**/*.{h,m,xib}"
  s.requires_arc = true
  s.


  s.dependency "React"
  s.dependency "Masonry"

end

  
